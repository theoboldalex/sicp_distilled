;; Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with
;; is using applicative-order evaluation or normal-order evaluation.

;; He defines the following two functions:

(defn p []
  (p))

(defn test [x y]
  (if (= x 0)
      0
      y))

;; Then he evaluates the expression

(test 0 (p)) ;; clojure  throws an unhandled java.lang.StackOverflowError

;; Q: What behavior will Ben observe with an interpreter that uses applicative-order evaluation?
;; first we lookup the body of test
(if (= x 0) 0 y)
;; next we replace all values in place
(if (= 0 0) 0 (p))
;; A: p recurs infinitely until the stack overflows

;; Q: What behavior will he observe with an interpreter that uses normal-order evaluation?
;; A: First, we lookup the body of test
(if (= x 0) 0 y)
;; Next we evaluate the operator before the operands
(= x 0)
;; we replace x with the argument applied
(= 0 0)
;; next, we evaluate the if condition which evaluates to true
(= 0 0)
;; x is zero so zero is returned
0

;; (Assume that the evaluation rule for the special form if is the same whether the
;; interpreter is using normal or applicative order: The predicate expression is evaluated first,
;; and the result determines whether to evaluate the consequent or the alternative expression.)
