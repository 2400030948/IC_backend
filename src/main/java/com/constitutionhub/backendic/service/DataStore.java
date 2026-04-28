package com.constitutionhub.backendic.service;

import com.constitutionhub.backendic.model.Article;
import com.constitutionhub.backendic.model.ConstitutionPart;
import com.constitutionhub.backendic.model.DirectivePrinciple;
import com.constitutionhub.backendic.model.DiscussionPost;
import com.constitutionhub.backendic.model.FundamentalDuty;
import com.constitutionhub.backendic.model.FundamentalRight;
import com.constitutionhub.backendic.model.LegalFaq;
import com.constitutionhub.backendic.model.QuizQuestion;
import com.constitutionhub.backendic.model.User;
import com.constitutionhub.backendic.repository.ArticleRepository;
import com.constitutionhub.backendic.repository.ConstitutionPartRepository;
import com.constitutionhub.backendic.repository.DirectivePrincipleRepository;
import com.constitutionhub.backendic.repository.DiscussionPostRepository;
import com.constitutionhub.backendic.repository.FundamentalDutyRepository;
import com.constitutionhub.backendic.repository.FundamentalRightRepository;
import com.constitutionhub.backendic.repository.LegalFaqRepository;
import com.constitutionhub.backendic.repository.QuizQuestionRepository;
import com.constitutionhub.backendic.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DataStore {

    private final UserRepository users;
    private final ArticleRepository articles;
    private final ConstitutionPartRepository constitutionParts;
    private final FundamentalRightRepository fundamentalRights;
    private final FundamentalDutyRepository fundamentalDuties;
    private final DirectivePrincipleRepository directivePrinciples;
    private final LegalFaqRepository legalFaqs;
    private final QuizQuestionRepository quizQuestions;
    private final DiscussionPostRepository discussionPosts;

    public DataStore(
            UserRepository users,
            ArticleRepository articles,
            ConstitutionPartRepository constitutionParts,
            FundamentalRightRepository fundamentalRights,
            FundamentalDutyRepository fundamentalDuties,
            DirectivePrincipleRepository directivePrinciples,
            LegalFaqRepository legalFaqs,
            QuizQuestionRepository quizQuestions,
            DiscussionPostRepository discussionPosts
    ) {
        this.users = users;
        this.articles = articles;
        this.constitutionParts = constitutionParts;
        this.fundamentalRights = fundamentalRights;
        this.fundamentalDuties = fundamentalDuties;
        this.directivePrinciples = directivePrinciples;
        this.legalFaqs = legalFaqs;
        this.quizQuestions = quizQuestions;
        this.discussionPosts = discussionPosts;
    }

    @PostConstruct
    void seed() {
        if (users.count() == 0) {
            users.saveAll(List.of(
                    new User("u1", "John Admin", "admin@example.com", "admin123", "admin", "Active"),
                    new User("u2", "Jane Educator", "educator@example.com", "educator123", "educator", "Active"),
                    new User("u3", "Ram Citizen", "citizen@example.com", "citizen123", "citizen", "Active"),
                    new User("u4", "Priya Expert", "expert@example.com", "expert123", "legal-expert", "Active")
            ));
        }

        if (articles.count() == 0) {
            articles.saveAll(List.of(
                    new Article("a1", "The Preamble Explained", "Constitutional Expert", "2024-01-15", "Understanding the Preamble and its significance in the Indian Constitution.", 1250),
                    new Article("a2", "Article 21: Right to Life", "Legal Scholar", "2024-01-10", "A simple introduction to Article 21 and its landmark interpretations.", 980),
                    new Article("a3", "Fundamental Rights Overview", "Dr. Sharma", "2024-01-05", "A complete overview of Articles 12 to 35 and the six fundamental rights.", 2150)
            ));
        }

        if (constitutionParts.count() == 0) {
            constitutionParts.saveAll(List.of(
                    new ConstitutionPart("p1", "Part I", "The Union and its Territory", "Articles 1-4"),
                    new ConstitutionPart("p2", "Part II", "Citizenship", "Articles 5-11"),
                    new ConstitutionPart("p3", "Part III", "Fundamental Rights", "Articles 12-35"),
                    new ConstitutionPart("p4", "Part IV", "Directive Principles of State Policy", "Articles 36-51"),
                    new ConstitutionPart("p5", "Part V", "The Union Executive", "Articles 52-78"),
                    new ConstitutionPart("p6", "Part VI", "The States Executive", "Articles 154-178")
            ));
        }

        if (fundamentalRights.count() == 0) {
            fundamentalRights.saveAll(List.of(
                    new FundamentalRight("r1", "Right to Equality", "Articles 14-18", "Equality before law, equal protection of laws, and prohibition of discrimination."),
                    new FundamentalRight("r2", "Right to Freedom", "Articles 19-22", "Freedom of speech, expression, assembly, association, movement, residence, and profession."),
                    new FundamentalRight("r3", "Right Against Exploitation", "Articles 23-24", "Protection against human trafficking, forced labor, and child labor."),
                    new FundamentalRight("r4", "Right to Freedom of Religion", "Articles 25-28", "Freedom to profess, practice, and propagate religion."),
                    new FundamentalRight("r5", "Cultural and Educational Rights", "Articles 29-30", "Rights that protect cultural, language, and educational interests of minorities."),
                    new FundamentalRight("r6", "Right to Constitutional Remedies", "Article 32", "Right to approach the Supreme Court for enforcement of fundamental rights.")
            ));
        }

        if (fundamentalDuties.count() == 0) {
            fundamentalDuties.saveAll(List.of(
                    new FundamentalDuty("fd1", "To abide by the Constitution and respect its ideals and institutions."),
                    new FundamentalDuty("fd2", "To cherish and follow the noble ideals that inspired the national struggle for freedom."),
                    new FundamentalDuty("fd3", "To uphold and protect the sovereignty, unity, and integrity of India."),
                    new FundamentalDuty("fd4", "To defend the country and render national service when called upon."),
                    new FundamentalDuty("fd5", "To promote harmony and the spirit of common brotherhood."),
                    new FundamentalDuty("fd6", "To value and preserve the rich heritage of composite culture."),
                    new FundamentalDuty("fd7", "To protect and improve the natural environment."),
                    new FundamentalDuty("fd8", "To develop scientific temper, humanism, and the spirit of inquiry and reform."),
                    new FundamentalDuty("fd9", "To safeguard public property and abjure violence."),
                    new FundamentalDuty("fd10", "To strive toward excellence in all spheres of individual and collective activity."),
                    new FundamentalDuty("fd11", "To provide opportunities for education to children between six and fourteen years of age.")
            ));
        }

        if (directivePrinciples.count() == 0) {
            directivePrinciples.saveAll(List.of(
                    new DirectivePrinciple("d1", 36, "Definition", "Defines the State for Directive Principles."),
                    new DirectivePrinciple("d2", 37, "Application", "Directive Principles guide the State in making laws."),
                    new DirectivePrinciple("d3", 38, "Welfare of People", "The State shall strive to promote public welfare."),
                    new DirectivePrinciple("d4", 39, "Policy Principles", "The State shall direct policy toward justice and fair distribution."),
                    new DirectivePrinciple("d5", 43, "Living Wage", "The State shall endeavor to secure living wages and decent working conditions."),
                    new DirectivePrinciple("d6", 45, "Education", "The State shall provide early childhood care and education.")
            ));
        }

        if (legalFaqs.count() == 0) {
            legalFaqs.saveAll(List.of(
                    new LegalFaq("f1", "rights", "What is the Right to Equality?", "Article 14 says the State shall not deny equality before law or equal protection of laws."),
                    new LegalFaq("f2", "duties", "What are Fundamental Duties?", "Fundamental Duties are moral obligations of citizens toward the nation and society."),
                    new LegalFaq("f3", "constitution", "What is the Preamble?", "The Preamble introduces the Constitution and states its guiding values and objectives."),
                    new LegalFaq("f4", "remedies", "What is Article 32?", "Article 32 allows citizens to approach the Supreme Court to enforce fundamental rights.")
            ));
        }

        if (quizQuestions.count() == 0) {
            quizQuestions.saveAll(List.of(
                    new QuizQuestion("q1", "What is the Preamble of the Constitution?", List.of("Introduction to the Constitution", "Conclusion of the Constitution", "Body of the Constitution", "Appendix to the Constitution"), 0),
                    new QuizQuestion("q2", "How many Fundamental Rights are commonly listed in Part III?", List.of("5", "6", "7", "8"), 1),
                    new QuizQuestion("q3", "Article 21 protects:", List.of("Right to Equality", "Right to Life and Personal Liberty", "Right to Religion", "Cultural Rights"), 1),
                    new QuizQuestion("q4", "Which article deals with Equality before Law?", List.of("Article 12", "Article 14", "Article 16", "Article 19"), 1)
            ));
        }

        if (discussionPosts.count() == 0) {
            discussionPosts.saveAll(List.of(
                    new DiscussionPost("post1", "What is the significance of Article 14?", "I want to understand how equality before law works in daily life.", "Curious Learner", "2024-01-20", 8, 345),
                    new DiscussionPost("post2", "How do fundamental duties differ from rights?", "Rights can be enforced in court, but duties are civic responsibilities.", "Legal Student", "2024-01-18", 12, 567)
            ));
        }
    }

    public List<User> users() { return users.findAll(); }

    public Optional<User> findUserByEmail(String email) {
        return users.findByEmailIgnoreCase(email);
    }

    public User addUser(String name, String email, String password, String role) {
        return users.save(new User(UUID.randomUUID().toString(), name, email, password, normalizeRole(role), "Active"));
    }

    public String normalizeRole(String role) {
        if (role == null || role.isBlank()) {
            return "citizen";
        }
        return role.trim().toLowerCase();
    }

    public List<Article> articles() { return articles.findAll(); }
    public List<ConstitutionPart> constitutionParts() { return constitutionParts.findAll(); }
    public List<FundamentalRight> fundamentalRights() { return fundamentalRights.findAll(); }
    public List<String> fundamentalDuties() {
        return fundamentalDuties.findAll().stream().map(FundamentalDuty::getDutyText).toList();
    }
    public List<DirectivePrinciple> directivePrinciples() { return directivePrinciples.findAll(); }
    public List<LegalFaq> legalFaqs() { return legalFaqs.findAll(); }
    public List<QuizQuestion> quizQuestions() { return quizQuestions.findAll(); }
    public List<DiscussionPost> discussionPosts() { return discussionPosts.findAllByOrderByDateDesc(); }

    public DiscussionPost addDiscussionPost(DiscussionPost post) {
        return discussionPosts.save(post);
    }
}
