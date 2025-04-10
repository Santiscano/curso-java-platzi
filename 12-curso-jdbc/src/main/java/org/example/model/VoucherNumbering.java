package org.example.model;

public class VoucherNumbering {
    private Integer idvoucher_numbering;
    private int number_voucher_numbering;
    private String letter_voucher_numbering;

    public VoucherNumbering() {
    }

    public VoucherNumbering(Integer idvoucher_numbering, int number_voucher_numbering, String letter_voucher_numbering) {
        this.idvoucher_numbering = idvoucher_numbering;
        this.number_voucher_numbering = number_voucher_numbering;
        this.letter_voucher_numbering = letter_voucher_numbering;
    }

    public Integer getIdvoucher_numbering() {
        return idvoucher_numbering;
    }

    public void setIdvoucher_numbering(Integer idvoucher_numbering) {
        this.idvoucher_numbering = idvoucher_numbering;
    }

    public String getLetter_voucher_numbering() {
        return letter_voucher_numbering;
    }

    public void setLetter_voucher_numbering(String letter_voucher_numbering) {
        this.letter_voucher_numbering = letter_voucher_numbering;
    }

    public int getNumber_voucher_numbering() {
        return number_voucher_numbering;
    }

    public void setNumber_voucher_numbering(int number_voucher_numbering) {
        this.number_voucher_numbering = number_voucher_numbering;
    }

    @Override
    public String toString() {
        return "VoucherNumbering{" +
                "idvoucher_numbering=" + idvoucher_numbering +
                ", number_voucher_numbering=" + number_voucher_numbering +
                ", letter_voucher_numbering='" + letter_voucher_numbering + '\'' +
                '}';
    }
}
