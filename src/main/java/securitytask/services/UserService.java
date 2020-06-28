package securitytask.services;

import javassist.compiler.SymbolTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import securitytask.dao.RoleDAO;
import securitytask.dao.UserDAO;
import securitytask.entity.Role;
import securitytask.entity.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    UserDAO userDAO;
    RoleDAO roleDAO;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.getByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole().getRole()));
        return  new org.springframework.security.core.userdetails.User
                (user.getLogin(),
                        user.getPassword(), enabled, accountNonExpired,
                        credentialsNonExpired, accountNonLocked,
                        roles);
    }


    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAO.addUser(user);
    }

    public void addUser(User user, String roleName) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleDAO.getByRoleName(roleName);
        user.setRole(role);
        userDAO.addUser(user);
    }

    public User getUserByLogin(String login) {
        User user = userDAO.getByLogin(login);
        return user;
    }


    public List<User> findAllUsers() {
        return userDAO.getAllUsers();
    }
}
