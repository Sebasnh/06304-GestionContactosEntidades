/*
 * Copyright 2020 Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es
 */
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String DEF_ALIAS = "Aupatú";

    public static final int DEF_EDAD = 18;

    public static final int MIN_CAR = 3;
    public static final int MAX_CAR = 10;

    public static final int MAX_EDAD = 195;

    private String alias;
    private int edad;

    public Contacto() {
        alias = DEF_ALIAS;
        edad = DEF_EDAD;
    }

    public Contacto(String alias, int edad) {
        if (validarAlias(alias)) {
            this.alias = alias;
        } else {
            this.alias = DEF_ALIAS;
        }
        if (validarEdad(edad)) {
            this.edad = edad;

        } else {
            this.edad = DEF_EDAD;

        }
    }
    

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        if (validarAlias(alias)) {
            this.alias = alias;
        } 
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
         if (validarEdad(edad)) {
            this.edad = edad;

        }
    }

    @Override
    public final boolean equals(Object o) {
        boolean testOK;
        if (o == null) {
            testOK = false;
        } else if (!(o instanceof Contacto)) {
            testOK = false;
        } else {
            testOK = (alias == null ? ((Contacto) o).getAlias()
                    == null : alias.equals(((Contacto) o).getAlias()))
                    && edad == ((Contacto) o).getEdad();
        }
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.alias);
        hash = 53 * hash + this.edad;
        return hash;
    }

    @Override
    public String toString() {
        return String.format("%s - Nombre de usuario a contactar: %s - Edad: %d",
                getClass().getSimpleName(), alias, edad);
    }

    private boolean validarAlias(String alias) {
        return alias.length() <= MAX_CAR && alias.length() >= MIN_CAR
                && !alias.matches(".*[\\s]+.*");

    }

    private boolean validarEdad(int edad) {
        return edad >= DEF_EDAD && edad <= MAX_EDAD;
    }

}
