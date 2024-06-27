package com.mycompany.tranbajofinalprogii.Logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class list {

    public node cab;

    public list() {
        cab = null;
    }

    public int longList() {
        node j = cab;
        int i = 0;
        if (isEmpty()) {
            return 0;
        } else {
            do {
                i++;
                j = j.next;
            } while (j != cab);
            return i;
        }
    }

    // Returna el ultimo elemento
    public node getEnd() {
        node j = cab;
        if (isEmpty()) {
            return null;
        } else {
            j = cab.prev;
            return j;
        }
    }

    // Comprueba si la lista esta vacia
    public boolean isEmpty() {
        return cab == null;
    }

    // Busca una node que tenga el nombre de usuario dado, si no la encuentra,
    // returna null
    public node searchNode(node a) {
        if (isEmpty()) {
            return null;
        } else {
            cuenta z = (cuenta) a;
            cuenta j = (cuenta) cab;
            do {
                if (j.username.equals(z.username)) {
                    return j;
                } else {
                    j = (cuenta) j.next;
                }
            } while (j != cab);
            return null;
        }
    }

    public node searchPos(int pos) {
        if (isEmpty()) {
            return null;
        } else {
            node j = cab;
            int i = 1;
            do {
                if (i == pos) {
                    return j;
                } else {
                    j = j.next;
                    i++;
                }
            } while (j != cab);
            return null;
        }
    }

    public node searchNode(cuenta a) {
        if (isEmpty()) {
            return null;
        } else {
            cuenta j = (cuenta) cab;
            do {
                if (j.username.equals(a.username)) {
                    System.out.println(j);
                    return j;
                } else {
                    j = (cuenta) j.next;
                }
            } while (j != cab);
            System.out.println("NULL");
            return null;
        }
    }

    // Crea un node y la añade al final de la lista
    public void createnode(node a) {
        if (searchNode(a) == null) {
            node ult = getEnd();
            if (cab == null) {
                cab = a;
                cab.next = cab;
                cab.prev = cab;
            } else if (ult == cab) {
                cab.next = a;
                cab.prev = a;
                a.next = cab;
                a.prev = cab;
            } else {
                ult.next = a;
                a.prev = ult;
                a.next = cab;
                cab.prev = a;
            }
        } else {
            System.out.println("Usuario existente");
        }
    }

    // Eliminar node de la lista
    public void deletenode(int pos) {
        if (pos < 0 || pos > longList()) {
            System.out.println("posicion no valida");
            return;
        }
        node j = searchPos(pos);
        if (j != null) {
            if (j == cab) {
                cab = cab.next;
                cab.prev = cab.prev.prev;
                cab.prev.next = cab;
            } else {
                j.prev.next = j.next;
                j.next.prev = j.prev;
            }
        } else {
            System.out.println("Error al buscar el elemento");
        }
    }

    // Imprime la lista en un archivo txt
    public void savelist(String url) throws IOException {
        File file = new File(url);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(listToJson().toString(2));
        bw.close();
    }

    // Convierte la lista a json
    public JSONArray listToJson() {
        JSONArray hash = new JSONArray();
        if (isEmpty()) {
            return hash;
        }
        node j = cab;
        do {
            hash.put(j.nodeToJson());
            j = j.next;
        } while (j != cab);

        return hash;
    }

    // Importa la lista de usuarios
    public void importList(String url) throws IOException {
        File file = new File(url);
        if (!file.exists()) {
            System.out.println("El archivo no existe");
            return;
        }
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        if (line == null) {
            System.out.println("La lista esta vacia");
            br.close();
            return;
        }
        StringBuilder jsoStringBuilder = new StringBuilder();
        while (line != null) {
            jsoStringBuilder.append(line);
            line = br.readLine();
        }
        JSONArray hash = new JSONArray(jsoStringBuilder.toString());
        for (int i = 0; i < hash.length(); i++) {
            JSONObject d = hash.getJSONObject(i);
            createnode(new cuenta(d));
        }
        br.close();

    }

}
