package com.huihuitf.library.service.impl;

//@Component
//public class MyUserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    //private PasswordEncoder passwordEncoder;
//    @Override
//    public UserDetails loadUserByUsername(String cardId) throws UsernameNotFoundException {
//        Long card=Long.decode(cardId);
//        String password=passwordEncoder.encode(userDao.queryUserByUserId(card).getPassword());
//        return new User(cardId,password, AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
//    }
//}
