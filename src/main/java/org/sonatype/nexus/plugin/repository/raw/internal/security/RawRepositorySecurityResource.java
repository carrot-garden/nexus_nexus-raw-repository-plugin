package org.sonatype.nexus.plugin.repository.raw.internal.security;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.security.realms.tools.AbstractStaticSecurityResource;

@Named
@Singleton
public class RawRepositorySecurityResource
    extends AbstractStaticSecurityResource
{
    @Override
    public String getResourcePath()
    {
        return "/META-INF/nexus-raw-repository-plugin-security.xml";
    }
}
