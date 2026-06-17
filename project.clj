(defproject becoming-novel "0.1.0-SNAPSHOT"
  :description "Becoming, a novel."
  :url "https://garbados.github.io/becoming-novel/"
  :main becoming-novel.build
  :license {:name "CC BY-NC-ND"
            :url "https://creativecommons.org/licenses/by-nc-nd/4.0/"}
  :dependencies [[org.clojure/clojure "1.12.2"]
                 [markdown-clj "1.12.8"]
                 [hbs "1.1.0"]]
  :repl-options {:init-ns becoming-novel.core}
  :aliases {"build" ["run" "-M" "becoming-novel.build"]})
