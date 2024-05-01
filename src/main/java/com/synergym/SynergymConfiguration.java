package com.synergym;

import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SynergymConfiguration extends Configuration {
    private DataSourceFactory dataSourceFactory;

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        if (Objects.isNull(dataSourceFactory))
            dataSourceFactory = new DataSourceFactory();

        return dataSourceFactory;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

}
