# lib/tasks/tddium.rake
#
# Rake task for Heroku deployment on Solano CI
#
#   Pushes successful CI builds on the staging branch to Heroku.
#   Set HEROKU_APP_NAME and HEROKU_API_KEY in the environment
#   and add the worker's SSH public key the Heroku app's accepted keys.
#
# Enjoy! -- wvengen

require 'rake'

def tddium_want_staging_build?
  ENV["TDDIUM_MODE"] == "ci" &&
    ENV["TDDIUM_BUILD_STATUS"] == "passed" &&
    ENV["TDDIUM_CURRENT_BRANCH"] == "staging"
end

def tddium_log *args
  STDERR.puts "\n"
  STDERR.puts args
end

namespace :tddium do
  desc "CI: Run post-build hooks"
  task :post_build_hook => [:staging_deploy, :staging_migrate]

  desc "CI: Deploy staging branch to Heroku"
  task :staging_deploy do
    if tddium_want_staging_build?
      tddium_log "Pushing staging to Heroku (backend)"
      unless system "git push git@heroku.com:#{ENV['HEROKU_APP_NAME']}.git HEAD:master --force"
        abort "Error pushing to Heroku, aborting"
      end
    end
  end

  desc "CI: Upgrade staging database on Heroku"
  task :staging_migrate do
    if tddium_want_staging_build?
      Bundler.with_clean_env do
        tddium_log "Running any database migrations"
        app = ENV['HEROKU_APP_NAME']
        unless system "heroku run --app #{app} rake db:migrate"
          abort "Error running database migrations - please ROLLBACK deploy, staging is in an inconsistent state!"
        end
        system "heroku restart --app #{app}"
      end
    end
  end

end

Rake::Task['tddium:post_build_hook'].execute
