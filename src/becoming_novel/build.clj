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
    (doseq [{:keys [slug html] :as entry} entries]
      (spit (str "public/" slug ".html")
            (hbs/render-file hbs-registry "page"
                             {:config config
                              :page (assoc entry :html html)})))))
