/*
 * This file is generated by jOOQ.
 */
package com.example.jooqcsv.db.information_schema.tables;


import com.example.jooqcsv.db.information_schema.InformationSchema;
import com.example.jooqcsv.db.information_schema.tables.records.KeyColumnUsageRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class KeyColumnUsage extends TableImpl<KeyColumnUsageRecord> {

    private static final long serialVersionUID = 1178464604;

    /**
     * The reference instance of <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE</code>
     */
    public static final KeyColumnUsage KEY_COLUMN_USAGE = new KeyColumnUsage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<KeyColumnUsageRecord> getRecordType() {
        return KeyColumnUsageRecord.class;
    }

    /**
     * The column <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_CATALOG</code>.
     */
    public final TableField<KeyColumnUsageRecord, String> CONSTRAINT_CATALOG = createField(DSL.name("CONSTRAINT_CATALOG"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_SCHEMA</code>.
     */
    public final TableField<KeyColumnUsageRecord, String> CONSTRAINT_SCHEMA = createField(DSL.name("CONSTRAINT_SCHEMA"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_NAME</code>.
     */
    public final TableField<KeyColumnUsageRecord, String> CONSTRAINT_NAME = createField(DSL.name("CONSTRAINT_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_CATALOG</code>.
     */
    public final TableField<KeyColumnUsageRecord, String> TABLE_CATALOG = createField(DSL.name("TABLE_CATALOG"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_SCHEMA</code>.
     */
    public final TableField<KeyColumnUsageRecord, String> TABLE_SCHEMA = createField(DSL.name("TABLE_SCHEMA"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_NAME</code>.
     */
    public final TableField<KeyColumnUsageRecord, String> TABLE_NAME = createField(DSL.name("TABLE_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.COLUMN_NAME</code>.
     */
    public final TableField<KeyColumnUsageRecord, String> COLUMN_NAME = createField(DSL.name("COLUMN_NAME"), org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.ORDINAL_POSITION</code>.
     */
    public final TableField<KeyColumnUsageRecord, Integer> ORDINAL_POSITION = createField(DSL.name("ORDINAL_POSITION"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.POSITION_IN_UNIQUE_CONSTRAINT</code>.
     */
    public final TableField<KeyColumnUsageRecord, Integer> POSITION_IN_UNIQUE_CONSTRAINT = createField(DSL.name("POSITION_IN_UNIQUE_CONSTRAINT"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE</code> table reference
     */
    public KeyColumnUsage() {
        this(DSL.name("KEY_COLUMN_USAGE"), null);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE</code> table reference
     */
    public KeyColumnUsage(String alias) {
        this(DSL.name(alias), KEY_COLUMN_USAGE);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE</code> table reference
     */
    public KeyColumnUsage(Name alias) {
        this(alias, KEY_COLUMN_USAGE);
    }

    private KeyColumnUsage(Name alias, Table<KeyColumnUsageRecord> aliased) {
        this(alias, aliased, null);
    }

    private KeyColumnUsage(Name alias, Table<KeyColumnUsageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> KeyColumnUsage(Table<O> child, ForeignKey<O, KeyColumnUsageRecord> key) {
        super(child, key, KEY_COLUMN_USAGE);
    }

    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    @Override
    public KeyColumnUsage as(String alias) {
        return new KeyColumnUsage(DSL.name(alias), this);
    }

    @Override
    public KeyColumnUsage as(Name alias) {
        return new KeyColumnUsage(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public KeyColumnUsage rename(String name) {
        return new KeyColumnUsage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public KeyColumnUsage rename(Name name) {
        return new KeyColumnUsage(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<String, String, String, String, String, String, String, Integer, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
