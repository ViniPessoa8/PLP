-module(q4).

-export([start/0]).

area(Raio) -> [math:pi() * math:pow(Raio, 2)].

start() ->
    {ok, Raio} = io:read("Informe o raio: "),
    io:fwrite("~w~n", area(Raio)).
