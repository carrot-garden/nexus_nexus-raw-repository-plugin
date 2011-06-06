package org.sonatype.nexus.plugin.repository.raw.internal;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.proxy.registry.AbstractIdContentClass;
import org.sonatype.nexus.proxy.registry.ContentClass;

@Named( DefaultRawRepositoryContentClass.ID )
@Singleton
public class DefaultRawRepositoryContentClass
    extends AbstractIdContentClass
{
    static final String ID = "raw";

    public String getId()
    {
        return ID;
    }

    @Override
    public boolean isCompatible( final ContentClass contentClass )
    {
        return false;
    }

    @Override
    public boolean isGroupable()
    {
        return false;
    }

}