(defun area-circulo(rad)
   (princ "Area do circulo: ")
   (princ (* 3.141592 rad rad))
)

(defun main()
    (area-circulo (read))
)