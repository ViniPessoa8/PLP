-- 1
soma a b = a + b

-- 2
menorDeDois a b =   if a > b
                    then b
                    else a

-- 3
menorDeTres a b c = if (a < b && a < c)
                    then a
                    else if (b < a && b < c)
                    then b
                    else c

-- 4
areaCircunf r = 3.1415 * (r * r)

-- 5
andTres a b c = (a && b && c)

-- 6
a # b = if (a == b)
    then a 
    else a ++ b

-- 7
fatores n = [i | i<-[1..n], n `mod` i == 0]
primo n = if ((fatores n) == [1,n])
    then True
    else False
    
-- 8
fatorial 1 = 1
fatorial n = n * fatorial (n-1)

-- 9
fibs = 0 : 1 : zipWith (+) fibs (tail fibs)

-- 10
get (a:b) n = if (n == 1)
    then a 
    else get b (n-1)