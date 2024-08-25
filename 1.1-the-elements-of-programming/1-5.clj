;; Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with
;; is using applicative-order evaluation or normal-order evaluation.

;; He defines the following two functions:

(defn p []
  (p))

(defn p []
  (p))

;; Then he evaluates the expression

(test 0 (p))

;; Q: What behavior will Ben observe with an interpreter that uses applicative-order evaluation?
;; A:

;; Q: What behavior will he observe with an interpreter that uses normal-order evaluation?
;; A:

;; (Assume that the evaluation rule for the special form if is the same whether the
;; interpreter is using normal or applicative order: The predicate expression is evaluated first,
;; and the result determines whether to evaluate the consequent or the alternative expression.)
