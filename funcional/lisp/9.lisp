(defun fibonacci (n)
    (if (< n 2) 
    n
    (+ (fibonacci (- n 1)) (fibonacci (- n 2))))
)

(defun main()
    (princ "Fibonacci ate o numero: ")
    (loop for i from 1 to (read)
        do (princ (fibonacci i))
        (fresh-line)
    )
)