(ns uralsclj-core.model-test
  (:require [clojure.test :refer :all]
            [uralsclj-core.model :as m]
            [clojure.spec.alpha :as s]))

(deftest render-to-template-test
  (testing "render-to-template-test"
    (is (= "Hello John! I'm Mike" 
        (m/render-to-template "Hello {{a1}}! I'm {{a2}}" {"a1" "John" :a2 "Mike"})))))