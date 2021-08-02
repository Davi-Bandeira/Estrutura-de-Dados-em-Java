package com.projeto.pilha;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public void push(No novoNo) {
        No refAuxiliar = this.refNoEntradaPilha;
        this.refNoEntradaPilha = novoNo;
        this.refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    public No pop() {
        if (!this.isEmpty()) {
            No noPoped = this.refNoEntradaPilha;
            this.refNoEntradaPilha = this.refNoEntradaPilha.getRefNo();
            return noPoped;
        }
        return null;
    }

    public No top() {
        return this.refNoEntradaPilha;
    }

    public boolean isEmpty() {

        return this.refNoEntradaPilha == null;
    }

    @Override
    public String toString() {
        String stringRetorno = "------------\n";
        stringRetorno += "    Pilha\n";
        stringRetorno += "------------\n";
        No noAuxiliar = this.refNoEntradaPilha;

        while (true) {
            if (noAuxiliar != null) {
                stringRetorno += "[No{dado=" + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            } else {
                break;
            }
        }
        stringRetorno += "============\n";
        return stringRetorno;
    }
}
