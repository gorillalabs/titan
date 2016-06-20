package com.thinkaurelius.titan.hadoop;

import com.thinkaurelius.titan.CassandraStorageSetup;
import com.thinkaurelius.titan.diskstorage.configuration.ModifiableConfiguration;
import com.thinkaurelius.titan.diskstorage.configuration.WriteConfiguration;

import org.apache.commons.io.FileUtils;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.util.GraphFactory;
import org.junit.Before;
import java.io.File;
import java.io.IOException;
    @Before
    public void setup() throws IOException {
        FileUtils.deleteDirectory(new File("output"));
    }

public class CassandraInputFormatIT extends AbstractInputFormatIT {

    protected Graph getGraph() {
        return GraphFactory.open("target/test-classes/cassandra-read.properties");
    }

    @Override
    public WriteConfiguration getConfiguration() {
        String className = getClass().getSimpleName();
        ModifiableConfiguration mc = CassandraStorageSetup.getEmbeddedConfiguration(className);
        return mc.getConfiguration();
    }
}
