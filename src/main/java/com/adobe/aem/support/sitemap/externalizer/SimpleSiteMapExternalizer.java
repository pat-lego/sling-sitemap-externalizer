package com.adobe.aem.support.sitemap.externalizer;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.sitemap.spi.common.SitemapLinkExternalizer;
import org.jetbrains.annotations.Nullable;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.commons.Externalizer;

@Component(property = {
        Constants.SERVICE_RANKING + ":Integer=" + Integer.MAX_VALUE
}, service = SitemapLinkExternalizer.class, immediate = true)
public class SimpleSiteMapExternalizer implements SitemapLinkExternalizer {

    private Externalizer externalizer;

    @Activate
    public SimpleSiteMapExternalizer(@Reference Externalizer externalizer,
            @Reference ResourceResolverFactory resourceResolverFactory) {
        this.externalizer = externalizer;
    }

    @Override
    public @Nullable String externalize(Resource arg0) {
        // DO SOMETHING WITH THE EXTERNALIZER
        return "http://localhost:4502" + arg0.getPath();
    }

    @Override
    public @Nullable String externalize(SlingHttpServletRequest arg0, String arg1) {
        // DO SOMETHING WITH THE EXTERNALIZER
        return "http://localhost:4502" + arg1;
    }

}
