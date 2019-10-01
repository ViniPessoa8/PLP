-module(q10).
-import(lists,[append/2, nth/2]). 
-export([start/0]).

leitura(Lista) ->
    Entrada = io:get_line("Informe um valor ou deixe vazio para finalizar: "),
    case string:len(Entrada) - 1 == 0 of
        true -> Lista;
        false ->
            ListaAux = append(Lista, [string:chomp(Entrada)]),
            leitura(ListaAux)
    end.

getIndice(Indice, Lista) ->
    Length = length(Lista),
    if 
        (Indice < 0) or (Indice > Length) -> "O indice informado nao existe";
        true -> nth(Indice, Lista)
    end.

start() ->
    Lista = leitura([]),
    {ok, Indice} = io:read("Informe o indice que deseja: "),
    io:fwrite("~p~n", [getIndice(Indice, Lista)]).

