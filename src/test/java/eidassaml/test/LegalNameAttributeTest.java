package eidassaml.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import eidassaml.starterkit.person_attributes.legal_persons_attributes.LegalNameAttribute;
import eidassaml.starterkit.person_attributes.natural_persons_attribute.GivenNameAttribute;
import eidassaml.starterkit.template.TemplateLoader;


public class LegalNameAttributeTest {
	
	@Test
	public void testGenerateLegalNameAttributeWithNonLatinScript() throws IOException {
		TemplateLoader.init();
		LegalNameAttribute attribute = new LegalNameAttribute("name", "\u03A9\u03BD\u03AC\u03C3\u03B7\u03C2");
		String xml = attribute.generate();
		System.out.println(xml);
		Assert.assertTrue(xml.contains("name"));
		Assert.assertTrue(xml.contains("LatinScript=\"false\">"));
		Assert.assertTrue(xml.contains("\u03A9\u03BD\u03AC\u03C3\u03B7\u03C2"));
	}
	
	@Test
	public void testGenerateLegalNameAttributeEmptyNonLatin() throws IOException {
		TemplateLoader.init();
		LegalNameAttribute attribute = new LegalNameAttribute("name", "");
		String xml = attribute.generate();
		System.out.println(xml);
		Assert.assertTrue(xml.contains("name"));
		Assert.assertFalse(xml.contains("LatinScript=\"false\">"));
	}
	
	@Test
	public void testGenerateLegalNameAttributeNullNonLatin() throws IOException {
		TemplateLoader.init();
		LegalNameAttribute attribute = new LegalNameAttribute("name", null);
		String xml = attribute.generate();
		System.out.println(xml);
		Assert.assertTrue(xml.contains("name"));
		Assert.assertFalse(xml.contains("LatinScript=\"false\">"));
	}
	
	@Test
	public void testGenerateLegalNameAttribute() throws IOException {
		TemplateLoader.init();
		GivenNameAttribute attribute = new GivenNameAttribute("name");
		String xml = attribute.generate();
		System.out.println(xml);
		Assert.assertTrue(xml.contains("name"));
		Assert.assertFalse(xml.contains("LatinScript=\"false\">"));
	}
	
}
