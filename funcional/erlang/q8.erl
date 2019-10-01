-module(q8).

-export([start/0]).


fatorial(Numero, Resultado) ->
    Return = if
        Numero == 0 -> [Resultado];
        true -> 
            ResultadoAux = Resultado * Numero,
            NumeroAux = Numero -1,
            fatorial(NumeroAux, ResultadoAux)
    end,
    Return.

start() ->
    {ok, Numero} = io:read("Informe um numero: "),
    io:fwrite("~w~n", fatorial(Numero, 1)).

