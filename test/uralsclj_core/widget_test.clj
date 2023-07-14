(ns uralsclj-core.widget-test
  (:require [clojure.test :refer :all]
            [uralsclj-core.widget :refer :all]
            [clojure.spec.alpha :as s]))

(deftest widget-dsl-test
  (testing "Widget dsl empty"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {}))))
  (testing "Widget dsl contains css-collection"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:css ["hello"]}))))
  (testing "Widget dsl contains css-string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:css "hello"}))))
  (testing "Widget dsl contains js-collection"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:js ["hello"]}))))
  (testing "Widget dsl contains js-string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:js "hello"}))))
  (testing "Widget dsl contains html-collection"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:html ["hello"]}))))
  (testing "Widget dsl contains html-string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:html "hello"})))))

