package org.example.repository;

import org.example.model.VoucherNumbering;
import org.example.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VoucherNumberingRepository implements Repository<VoucherNumbering> {

    public Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    };

    @Override
    public List<VoucherNumbering> findAll() throws SQLException {
        List<VoucherNumbering> vouchers = new ArrayList<>();
        try(
                Statement statement = getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM voucher_numbering")
                ){
            while (resultSet.next()) {
                createVoucher(resultSet);
            }
        }
        return vouchers;
    }



    @Override
    public VoucherNumbering findById(Integer id) {

    }

    @Override
    public void save(VoucherNumbering voucherNumbering) {

    }

    @Override
    public void delete(Integer id) {

    }

    private VoucherNumbering createVoucher(ResultSet resultSet) throws SQLException {
        VoucherNumbering vouch = new VoucherNumbering();
        vouch.setIdvoucher_numbering(resultSet.getInt("idvoucher_numbering"));
        vouch.setNumber_voucher_numbering(resultSet.getInt("number_voucher_numbering"));
        vouch.setLetter_voucher_numbering(resultSet.getString("letter_voucher_numbering"));
        return vouch;
    }
}
