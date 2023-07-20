(ns uralsclj-core.app-test
  (:require [clojure.test :refer :all]
            [uralsclj-core.app :as app]
            [uralsclj-core.event :as e]
            [clojure.spec.alpha :as s]))

(defmethod e/handle "some" [h e s d] s)

(deftest valid?-test
    (testing "valid case"
        (is (= true (app/valid? {
            :declars [{
                :name "some-name" 
                :template "dsaka" 
                :init []
                :host "#dasd"
            }]
            :events {"#some" "some"}
            :deps {:dep1 2354}
        }))))
    (testing "invalid case"
        (is (= false (app/valid? {
            :declars [{
                :name "some-name" 
                :init []
                :host "#dasd"
            }]
            :events ["sad" 12]
            :deps {:dep1 2354}
        })))))