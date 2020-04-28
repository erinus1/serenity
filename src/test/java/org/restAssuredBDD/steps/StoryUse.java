package org.restAssuredBDD.steps;

import org.restAssuredBDD.scenarious.CheckInventoryTest;
import org.restAssuredBDD.scenarious.DeleteOrderIdTest;
import org.restAssuredBDD.scenarious.GetOrderIdTest;
import org.restAssuredBDD.scenarious.NewOrderTest;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;

public class StoryUse extends JUnitStories {
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(
                        new StoryReporterBuilder().withDefaultFormats()
                                .withFormats(Format.HTML, Format.CONSOLE));
    }

    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new CheckInventoryTest(), new NewOrderTest(), new GetOrderIdTest(), new DeleteOrderIdTest())
                .createCandidateSteps();
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("src\\test\\resources\\stories\\consult_dictionary\\PetActivity.story");
    }
}