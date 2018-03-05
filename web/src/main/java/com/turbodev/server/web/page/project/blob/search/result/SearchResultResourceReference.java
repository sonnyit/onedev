package com.turbodev.server.web.page.project.blob.search.result;

import java.util.List;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

import com.turbodev.server.web.asset.scrollintoview.ScrollIntoViewResourceReference;
import com.turbodev.server.web.asset.uri.URIResourceReference;
import com.turbodev.server.web.page.base.BaseDependentResourceReference;

public class SearchResultResourceReference extends BaseDependentResourceReference {

	private static final long serialVersionUID = 1L;

	public SearchResultResourceReference() {
		super(SearchResultResourceReference.class, "search-result.js");
	}

	@Override
	public List<HeaderItem> getDependencies() {
		List<HeaderItem> dependencies = super.getDependencies();
		dependencies.add(JavaScriptHeaderItem.forReference(new URIResourceReference()));
		dependencies.add(JavaScriptHeaderItem.forReference(new ScrollIntoViewResourceReference()));
		dependencies.add(CssHeaderItem.forReference(
				new CssResourceReference(SearchResultResourceReference.class, "search-result.css")));
		return dependencies;
	}

}
