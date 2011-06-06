package org.sonatype.nexus.plugin.repository.raw.internal;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.proxy.repository.AbstractRepositoryConfigurator;

@Named( DefaultRawRepositoryConfigurator.ID )
@Singleton
public class DefaultRawRepositoryConfigurator
    extends AbstractRepositoryConfigurator
{

    static final String ID = "raw";

}
