-module(q9).

-export([start/0]).

fibonacci(A, B, Controle) ->
    Return = if
        Controle == 1 -> [B];
        true ->
            C = A + B,
            ControleAux = Controle - 1,
            fibonacci(B, C, ControleAux)
    end,
    Return.

start() ->
    {ok, Numero} = io:read("Informe um numero: "),
    io:fwrite("~w~n", fibonacci(0, 1, Numero)).

