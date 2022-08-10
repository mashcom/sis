package mashcom.co.zw.sis.services;

import mashcom.co.zw.sis.models.Person;
import mashcom.co.zw.sis.repositories.PersonRepository;
import mashcom.co.zw.sis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByEmail(username);
        if (person == null) {
            throw new UsernameNotFoundException("User with email {} not found!");
        }
        mashcom.co.zw.sis.models.User user = userRepository.findByPersonId(person.getId());

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(person.getEmail(), user.getPassword(),authorities);

    }
}
