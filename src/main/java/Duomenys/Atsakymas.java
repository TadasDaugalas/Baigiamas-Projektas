package Duomenys;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Atsakymas<K,V> {
        private K klausimas;
        private V atsakymas;

        public Atsakymas() {
        }
        @JsonCreator
        public Atsakymas(@JsonProperty("klausimas") K klausimas, @JsonProperty("atsakymas") V atsakymas) {
            this.klausimas = klausimas;
            this.atsakymas = atsakymas;
        }

        public K getKlausimas() {
            return klausimas;
        }

        public V getAtsakymas() {
            return atsakymas;
        }

}
