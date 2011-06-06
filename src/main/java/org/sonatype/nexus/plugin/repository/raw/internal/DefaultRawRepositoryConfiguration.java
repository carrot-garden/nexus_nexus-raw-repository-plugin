package org.sonatype.nexus.plugin.repository.raw.internal;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.sonatype.nexus.proxy.repository.AbstractRepositoryConfiguration;

public class DefaultRawRepositoryConfiguration
    extends AbstractRepositoryConfiguration
{

    public DefaultRawRepositoryConfiguration( final Xpp3Dom configuration )
    {
        super( configuration );
    }

}
