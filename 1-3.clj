;; Define a function that takes three numbers as arguments and returns the sum of the squares
;; of the two larger numbers

(defn sum-of-squares [[x y]]
  (+ (* x x) (* y y)))

(defn sum-two-largest-squares [a b c]
  (sum-of-squares (cond
                    (= (min a b c) a) [b c]
                    (= (min a b c) c) [a b]
                    :else [a c])))

(sum-two-largest-squares 1 2 4) ;; 20
