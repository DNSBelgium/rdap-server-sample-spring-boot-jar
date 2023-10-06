package be.dnsbelgium.rdap.sample.springbootjar.service;

import be.dnsbelgium.rdap.core.*;
import be.dnsbelgium.rdap.service.impl.DefaultEntityService;
import be.dnsbelgium.vcard.Contact;
import be.dnsbelgium.vcard.datatype.Tel;
import be.dnsbelgium.vcard.datatype.Text;
import org.joda.time.DateTime;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static be.dnsbelgium.rdap.core.Entity.OBJECT_CLASS_NAME;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class SampleEntityService extends DefaultEntityService {

  public Entity getEntityImpl(String handle) throws RDAPError {
    Event lastChanged = new Event(Event.Action.Default.LAST_CHANGED, null, new DateTime(), null);
    List<Event> events = singletonList(lastChanged);
    List<Entity.Role> roles = singletonList(Entity.Role.Default.REGISTRAR);
    List<PublicId> publicIds = singletonList(new PublicId("input is id", handle));

    Contact rarContact;
    try {
      rarContact = createContact("name of registrar", "+32112233", "email@email.email");
    } catch (URISyntaxException e) {
      throw new RDAPError(123, "error");
    }

    Entity registrar = new Entity(null, null, null, null, OBJECT_CLASS_NAME, events, null, null,
        handle, rarContact, roles, null, publicIds, null);

    return registrar;
  }

  private Contact createContact(String name, String phone, String email) throws URISyntaxException {
    Contact.Property formattedName = Contact.Property.of("fn", Text.of(name));

    Tel tel = new Tel(phone);
    Contact.Property voice = new Contact.Property(null, "tel", new Contact.Parameters.Builder().add("type", "voice").build(), tel);

    Contact.Property emailProperty = Contact.Property.of("email", Text.of(email));
    Contact.Property address = null;

    List<Contact.Property> properties = Stream.of(formattedName, voice, emailProperty, address).filter(Objects::nonNull).collect(toList());

    return new Contact(properties);
  }

}
