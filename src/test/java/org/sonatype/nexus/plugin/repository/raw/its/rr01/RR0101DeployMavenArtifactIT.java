package org.sonatype.nexus.plugin.repository.raw.its.rr01;

import java.io.File;

import org.sonatype.nexus.integrationtests.AbstractNexusIntegrationTest;
import org.testng.annotations.Test;

public class RR0101DeployMavenArtifactIT
    extends AbstractNexusIntegrationTest
{

    public RR0101DeployMavenArtifactIT()
    {
        super( "rr01" );
    }

    /**
     * Test that deployed artifact can be downloaded.
     */
    @Test
    public void test()
        throws Exception
    {
        final File downloadDir = new File( "target/downloads/" + this.getClass().getSimpleName() );

        downloadArtifact( "commons-logging", "commons-logging", "1.1.1", "jar", null /* classifier */,
            downloadDir.getPath() );
        downloadArtifact( "commons-logging", "commons-logging", "1.1.1", "pom", null /* classifier */,
            downloadDir.getPath() );

    }

}
