$(function() {

  // Se existir campo texto,
  // seta autofocus
  var $text = document.querySelector('input[type=text]');
  if ( $text ) {
    $text.focus();
  }

  // Alias para ProgWeb
  var App = {};

  // Feature de login no sistema
  App.signin = function() {

    $('form').on('submit', function() {

      var email = $('input[name=email]'),
      password = $('input[name=password]'),
      hasErrors = false;

      // Valida email
      if ( ! _.checkEmail(email.val()) ) {
        hasErrors = true;
        email
          .parent()
          .addClass('has-error')
          .focus()
          .attr('title', 'E-mail inválido.');
      }

      // Valida senha
      if ( password.val() === '' ) {
        hasErrors = true;
        password
          .parent()
          .addClass('has-error')
          .focus()
          .attr('title', 'Informe uma senha.');
      }

      // Submete o form se nao houver erro
      if ( ! hasErrors ) {
        this.submit();
      }

      return false;

    });

  };


  /*
   * Client
   */
  App.client = {

    // Feature de registrar cliente
    new: function() {

      // Tratamento do form
      $('form').on('submit', function() {

        var nome = $('input[name=nome]'),
          cpf = $('input[name=cpf]'),
          cnpj = $('input[name=cnpj]'),
          endereco = $('input[name=endereco]'),
          hasErrors = false;

        // Exibe erro se o campo nome estiver vazio
        if ( nome.val() === '' ) {
          hasErrors = true;
          nome
            .parent()
            .addClass('has-error')
            .focus()
            .attr('title', nome.attr('placeholder'));
        }

        // Exibe erro se o campo CPF ou CNPJ estiverem vazio
        if ( cpf.val() === '' || cnpj.val() === '' ) {
          if ( cpf.val() === '' ) {
            hasErrors = true;
            cpf
              .parent()
              .addClass('has-error')
              .focus()
              .attr('title', cpf.attr('placeholder'));
          } else {
            hasErrors = true;
            cnpj
              .parent()
              .addClass('has-error')
              .focus()
              .attr('title', cnpj.attr('placeholder'));
          }
        }

        // Exibe erro se o campo endereco estiver vazio
        if ( endereco.val() === '' ) {
          hasErrors = true;
          endereco
            .parent()
            .addClass('has-error')
            .focus()
            .attr('title', endereco.attr('placeholder'));
        }

        // Submete o form se nao houver erro
        if ( ! hasErrors ) {
          this.submit();
        }

        return false;
      });

    },

    // Feature de localizar clientes
    find: function() {

      // Tratamento do form
      $('form').on('submit', function() {

        var cpf = $('input[name=cpf]'),
          cnpj = $('input[name=cnpj]'),
          hasErrors = false;

        // Exibe erro se o campo CPF ou CNPJ estiverem vazio
        if ( cpf.val() === '' ) {
          hasErrors = true;
          cpf
            .parent()
            .addClass('has-error')
            .focus()
            .attr('title', cpf.attr('placeholder'));
        }

        // Submete o form se nao houver erro
        if ( ! hasErrors ) {
          this.submit();
        }

        return false;

      });

    },


    // Feature de listagem de clientes
    // Usada tb para pesquisa de clientes
    list: function() {

      $('.btn-delete').on('click', function() {

        var hasConfirmed = confirm("Deseja realmente excluir os dados deste cliente do sistema?");
        if ( !hasConfirmed ) {
          return false;
        }

      });
    }

  };

  // Pega namespace com base no pathname da URL
  var route = window.location.pathname.replace('/', '').split('/').join('.');

  console.log(route);

  // Executa a funcao com base no namespace
  // Ex: Se estiver na pagina /client/list,
  // vai executar a funcao App.client.list()
  if ( _.has(App, route) ) {
    _.has(App, route)();
  }

  $('.form-control').on('keypress', function(){
    $(this).attr('title','').parent().removeClass('has-error');
  });

});
