(ns uralsclj-core.declar-test
  (:require [clojure.test :refer :all]
            [uralsclj-core.declar :as d]
            [clojure.spec.alpha :as s]))

(deftest valid?-test
    (testing "valid case"
        (is (= true (d/valid? {
            :name "some-name" 
            :template "dsaka" 
            :init []
            :host "#dasd"
        }))))
    (testing "invalid case"
        (is (= false (d/valid? {
            :name "some-name" 
            :init []
            :host "#dasd"
        })))))