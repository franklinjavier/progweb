/**
 * Minimal lodash
 * @author Franklin Javier (@franklinjavier)
 */

var _ = {};


/**
 * Verifica se `path` é uma propriedade direta
 *
 * @param object obj Objeto a ser verificado
 * @param string path Path a ser verificada
 * @return object Retorna o valor da propriedade (true), caso contrario, undefined
 *
 * @example
 *
 * var object = { a: { b: { c: 3 } } };
 *
 * Bom
 *
 * _.has(object, 'a');
 * -> true = {b: { c: 3 }}
 *
 * _.has(object, 'a.b.c');
 * -> true = 3
 *
 * Ruim
 *
 * if ('a' in object && 'b' in object.a && 'c' in object.a.b) {}
 *
 * if (object &&
 *     typeof object.a != 'undefined' &&
 *     typeof object.a.b != 'undefined' &&
 *     typeof object.a.b.c != 'undefined') {}
 *
 */
_.has = function( obj, str ) {

    str = str.split('.');
    obj = obj[ str.shift() ];

    while( obj && str.length) {
        obj = obj[ str.shift() ];
    }

    return obj;

};



/**
 * Verifica se o email informado é válido
 *
 * @param string email Email a ser validado
 * @return boolean
 */
_.checkEmail = function( email ) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test( email );
};

