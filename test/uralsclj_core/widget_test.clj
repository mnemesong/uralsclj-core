(ns uralsclj-core.widget-test
  (:require [clojure.test :refer :all]
            [uralsclj-core.widget :refer :all]
            [clojure.spec.alpha :as s]))

(deftest widget-dsl-test
  (testing "Widget/dsl may be empty"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {}))))
  (testing "Widget/dsl.css may be collection"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:css ["hello"]}))))
  (testing "Widget/dsl.css may be string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:css "hello"}))))
  (testing "Widget/dsl.css may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:css nil}))))
  (testing "Widget/dsl.css may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:css 12}))))
  (testing "Widget/dsl.js may be collection"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:js ["hello"]}))))
  (testing "Widget/dsl.js may be string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:js "hello"}))))
  (testing "Widget/dsl.js may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:js nil}))))
  (testing "Widget/dsl.js may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:js 0.12}))))
  (testing "Widget/dsl.html may be collection"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:html ["hello"]}))))
  (testing "Widget/dsl.html may be string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:html "hello"}))))
  (testing "Widget/dsl.html may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:html nil}))))
  (testing "Widget/dsl.html may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:html 0.12}))))
  (testing "Widget/dsl.engine may not be collection"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:engine ["hello"]}))))
  (testing "Widget/dsl.engine may be string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:engine "hello"}))))
  (testing "Widget/dsl.engine may be keyword"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:engine :hello}))))
  (testing "Widget/dsl.engine may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:engine nil}))))
  (testing "Widget/dsl.engine may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:engine 0.12})))))

