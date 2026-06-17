(ns becoming-novel.build
  (:require
   [becoming-novel.core :refer [toc entries]]
   [clojure.edn :as edn]
   [hbs.core :as hbs]))

(def hbs-registry (hbs/registry (hbs/classpath-loader "/templates" ".hbs")))

(def config (edn/read-string (slurp "resources/config.edn")))

(defn -main [& args]
  (let [config (assoc config :url (nth args 2 "/"))]
    (spit "public/index.html"
          (hbs/render-file hbs-registry "toc"
                           {:config config
                            :entries toc}))
    (doseq [[i {:keys [slug] :as entry}] (map-indexed vector entries)
            :let [next-entry (nth entries (inc i) nil)]]
      (spit (str "public/" slug ".html")
            (hbs/render-file hbs-registry "page"
                             {:config config
                              :page entry
                              :next next-entry})))))
