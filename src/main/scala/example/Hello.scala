package example

import java.io.File
import java.io.IOException
import java.io.OutputStream
import java.io.ByteArrayInputStream

import javax.xml.transform.Result
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerException
import javax.xml.transform.TransformerFactory
import javax.xml.transform.sax.SAXResult
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

import org.apache.fop.apps.FOPException
import org.apache.fop.apps.FOUserAgent
import org.apache.fop.apps.Fop
import org.apache.fop.apps.FopFactory
import org.apache.fop.apps.MimeConstants
import org.apache.xmlgraphics.util.MimeConstants.MIME_PNG

object Hello extends App {

  val xmlSource = new StreamSource(new ByteArrayInputStream(label.string.getBytes))
  val fopFactory = FopFactory.newInstance(new File(".").toURI())
  val foUserAgent = fopFactory.newFOUserAgent()
  val out = new java.io.FileOutputStream("/home/pepe/label.pdf")
  val fop = fopFactory.newFop(MIME_PNG, foUserAgent, out)

  // Setup XSLT
  val factory = TransformerFactory.newInstance()
  val transformer = factory.newTransformer(new StreamSource(new ByteArrayInputStream(label.xslt.getBytes)))

  // Resulting SAX events (the generated FO) must be piped through to FOP
  val res = new SAXResult(fop.getDefaultHandler())

  // Start XSLT transformation and FOP processing
  // That's where the XML is first transformed to XSL-FO and then
  // PDF is created


  println(res)
    println(xmlSource)

  transformer.transform(xmlSource, res)
}
