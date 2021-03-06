package com.projeto.Fila;

public class Fila<T> {

    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

//    public void enqueue(No novoNo) { // enfileirar
//        novoNo.setRefNo(this.refNoEntradaFila);
//        this.refNoEntradaFila = novoNo;
//    }

    //Refatorando metodo
    public void enqueue(T object) { // enfileirar
        No novoNo = new No(object);
        novoNo.setRefNo(this.refNoEntradaFila);
        this.refNoEntradaFila = novoNo;
    }

//    public No first() {
//        if (!this.isEmpty()) {
//            No primeiroNo = refNoEntradaFila;
//            while (true) {
//                if (primeiroNo.getRefNo() != null) {
//                    primeiroNo = primeiroNo.getRefNo();
//                } else {
//                    break;
//                }
//            }
//            return primeiroNo;
//        }
//        return null;
//    }

    //Refatorando metodo
    public T first() {
        if (!this.isEmpty()) {
            No primeiroNo = refNoEntradaFila;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

//    public No dequeue() { //desenfileirar
//        if (!this.isEmpty()) {
//            No primeiroNo = refNoEntradaFila;
//            No noAuxiliar = refNoEntradaFila;
//            while (true) {
//                if (primeiroNo.getRefNo() != null) {
//                    noAuxiliar = primeiroNo;
//                    primeiroNo = primeiroNo.getRefNo();
//                } else {
//                    noAuxiliar.setRefNo(null);
//                    break;
//                }
//            }
//            return primeiroNo;
//        }
//        return null;
//    }
//
//    public boolean isEmpty() {
//        return this.refNoEntradaFila == null;
//    }

    //Refatorando m??todo
public T dequeue() { //desenfileirar
    if (!this.isEmpty()) {
        No primeiroNo = refNoEntradaFila;
        No noAuxiliar = refNoEntradaFila;
        while (true) {
            if (primeiroNo.getRefNo() != null) {
                noAuxiliar = primeiroNo;
                primeiroNo = primeiroNo.getRefNo();
            } else {
                noAuxiliar.setRefNo(null);
                break;
            }
        }
        return (T) primeiroNo.getObject();
    }
    return null;
}

    public boolean isEmpty() {
        return this.refNoEntradaFila == null;
    }

    @Override
    public String toString() {

        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if (refNoEntradaFila != null) {
            while (true) {
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}] ----> ";
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    stringRetorno += "null\n";
                    break;
                }
            }
        } else {
            stringRetorno = "null";
        }
        return stringRetorno;
    }
}
