package com.example.api.user;


import com.example.domain.user.Member;
import com.example.repository.user.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("members")
public class MemberRestController {
    @Autowired
    MemberRepository memberRepository;

    @RequestMapping(method = RequestMethod.POST)
    public List<Member> postMembers(@RequestBody List<Member> members) {
        List<Member> created = memberRepository.save(members);
        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Member> getMembers() {
        List<Member> members = memberRepository.findAll();
        return members;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Member getMember(@PathVariable String id) {
        Member member = memberRepository.findOne(id);
        return member;
    }

    //TODO: necessary ???
    @RequestMapping(method = RequestMethod.PUT)
    public List<Member> putMembers(@RequestBody List<Member> members) {
        List<Member> updated = memberRepository.save(members);
        return updated;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Member putMember(@PathVariable String id,
                            @RequestBody Member member) {
        Member found = memberRepository.findOne(id);
        Member updated = null;

        if (found != null) {
            updated = memberRepository.save(member);
        }

        return updated;
    }

    //TODO: necessary ??? --> a little
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteMembers() {
        memberRepository.deleteAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteMember(@PathVariable String id) {
        memberRepository.delete(id);
    }
}
