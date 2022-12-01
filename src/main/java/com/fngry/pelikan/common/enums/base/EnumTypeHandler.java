package com.fngry.pelikan.common.enums.base;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mybatis enum转换
 * @author gaorongyu 
 */
public class EnumTypeHandler extends BaseTypeHandler<EnumType> {

    private Class<EnumType> type;

    public EnumTypeHandler() {
        super();
    }

    public EnumTypeHandler(Class<EnumType> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EnumType parameter, JdbcType jdbcType) throws SQLException {
        if (parameter.code() instanceof String) {
            ps.setString(i, (String) parameter.code());
        } else if (parameter.code() instanceof Long) {
            ps.setLong(i, (long) parameter.code());
        } else {
            ps.setInt(i, (int) parameter.code());
        }
    }

    @Override
    public EnumType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Object code = rs.getObject(columnName);
        return rs.wasNull() ? null : codeOf(type, code);
    }

    @Override
    public EnumType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Object code = rs.getObject(columnIndex);
        return rs.wasNull() ? null : codeOf(type, code);
    }

    @Override
    public EnumType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object code = cs.getObject(columnIndex);
        return cs.wasNull() ? null : codeOf(type, code);
    }

    private <E extends EnumType> E codeOf(Class<E> enumClass, Object code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.code().equals(code)) {
                return e;
            }
        }
        return null;
    }

}
