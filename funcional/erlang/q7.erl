-module(q7).

-export([start/0]).

primoAux(Limite, Iterador, Divisores) ->
    Return = if 
        Iterador > Limite -> Divisores;
        Iterador =< Limite ->
            case Limite rem Iterador == 0 of
                true -> DivisoresAux = Divisores + 1;
                false -> DivisoresAux = Divisores
            end,
            IteradorAux = Iterador + 1,
            primoAux(Limite, IteradorAux, DivisoresAux)
    end,
    Return.

primo(Numero) -> 
    Divisores = primoAux(Numero, 1, 0),
    Divisores == 2.

start() ->
    {ok, Numero} = io:read("Informe um numero: "),
    case primo(Numero) of
      true -> io:fwrite("~p~n", ["O numero informado e primo"]);
      false -> io:fwrite("~p~n", ["O numero informado nao e primo"])
    end.
