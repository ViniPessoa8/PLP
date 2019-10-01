% Fatos

forca.
darth_vader.
padme.
luke.
leia.
rey.
shmi.
yoda.
darth_sidious.

feminino(leia).
feminino(rey).
feminino(padme).
feminino(shmi).

masculino(darth_vader).
masculino(luke).
masculino(yoda).
masculino(darth_sidious).

% Hierarquia

pai(darth_vader, luke).
pai(darth_vader, leia).
pai(padme, luke).
pai(padme, leia).
pai(shmi, darth_vader).
pai(luke, rey).

% Força

lightside(yoda).
lightside(leia).
lightside(rey).
lightside(padme).
lightside(shmi).
lightside(luke).

darkside(darth_sidious).
darkside(darth_vader).

novato(forca).
padawan(forca).
cavaleiro_jedi(forca).
mestre_jedi(luke).
mestre_conselheiro(forca).
grao_mestre(yoda).

lacaio(forca).
novico(forca).
guerreiro(forca).
lorde_sith(darth_vader).
lorde_sombrio(darth_sidious).

mestre(yoda, luke).
mestre(darth_sidious, darth_vader).

trocou(darth_vader).

jedi(yoda).
jedi(luke).

sith(darth_vader).
sith(darth_sidious).

matou(darth_vader, darth_sidious).
matou(darth_sidious, darth_vader).
matou(yoda, yoda).

% Regras
pai(A, B) :-
    masculino(A),
    pai(A, B).

mae(A, B) :-
    feminino(A),
    pai(A, B).

avo(A, B) :-
    pai(A, X),
    pai(X, B);
	mae(A, X),
    mae(X, B).

tio(T, A) :-
    masculino(T),
    irmaos(T, X),
    pai(X, A).

tia(T, A) :-
    feminino(T),
    irmaos(T, X),
    pai(X, A).

irmaos(X, Y) :-
    pai(Z, X),
    pai(Z, Y),
    X\=Y.