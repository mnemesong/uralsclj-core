(ns uralsclj-core.event-test
  (:require [clojure.test :refer :all]
            [uralsclj-core.event :as e]
            [clojure.spec.alpha :as s]))

(defmethod e/handle "true" [h e s d] s)

(deftest valid?-test
    (testing "valid test"
        (is (= true (e/valid? "true"))))
    (testing "invalid test"
        (is (= false (e/valid? "some-else")))))