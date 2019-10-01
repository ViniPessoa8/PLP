-module(q6).

-export([start/0]).

'#'(A, B) ->
    case string:equal(A, B) of
        false -> string:concat(A, B);
        true -> A
    end.

start() ->
    A = io:get_line("Informe a primeira string: "),
    B = io:get_line("Informe a segunda string: "),
    io:fwrite("~p~n", ['#'(string:chomp(A), string:chomp(B))]).

