package com.cedricakrou.my.blog.user.domain.entities;

import com.cedricakrou.library.generic.aggregate.domain.AbstractEntityBuilder;
import com.cedricakrou.library.generic.aggregate.domain.DomainEntityRoot;
import com.cedricakrou.my.blog.user.domain.value.objects.EmploymentType;
import com.cedricakrou.my.blog.user.domain.value.objects.Skill;
import com.cedricakrou.my.blog.user.domain.value.objects.Task;
import java.util.UUID;

/**
 * <p>Entity representing user experience.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-06
 */
public class Experience extends DomainEntityRoot {

  private final String title;
  private final String description;
  private final EmploymentType employmentType;
  private final int order;
  private final String companyName;
  private final String companyLink;
  private final String companyImageUrl;
  private final String location;
  private final String startDate;
  private final String endDate;
  private final boolean isCurrentlyWorking;
  private final Skill[] skills;
  private final Task[] tasks;

  private Experience(final ExperienceBuilder builder) {
    super(builder.getId(), builder.isEnabled(), builder.isDeleted());
    this.title = builder.title;
    this.description = builder.description;
    this.employmentType = builder.employmentType;
    this.order = builder.order;
    this.companyName = builder.companyName;
    this.companyLink = builder.companyLink;
    this.companyImageUrl = builder.companyImageUrl;
    this.location = builder.location;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.isCurrentlyWorking = builder.isCurrentlyWorking;
    this.skills = builder.skills;
    this.tasks = builder.tasks;
  }

  public static class ExperienceBuilder extends
          AbstractEntityBuilder<Experience> {

    private String title;
    private String description;
    private EmploymentType employmentType;
    private int order;
    private String companyName;
    private String companyLink;
    private String companyImageUrl;
    private String location;
    private String startDate;
    private String endDate;
    private boolean isCurrentlyWorking;
    private Skill[] skills;
    private Task[] tasks;

    /**
     * <p>Default constructor.</p>
     *
     * @param id      Identifier.
     * @param enabled enabled.
     * @param deleted deleted.
     */
    protected ExperienceBuilder(final UUID id,
                                final boolean enabled,
                                final boolean deleted) {
      super(id, enabled, deleted);
    }

    /**
     * <p>Change title Value.</p>
     *
     * @param title title.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setTitle(final String title) {
      this.title = title;
      return this;
    }

    /**
     * <p>Change description Value.</p>
     *
     * @param description description.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setDescription(final String description) {
      this.description = description;
      return this;
    }

    /**
     * <p>Change employment type Value.</p>
     *
     * @param employmentType employmentType.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setEmploymentType(
            final EmploymentType employmentType
    ) {
      this.employmentType = employmentType;
      return this;
    }

    /**
     * <p>Change order Value.</p>
     *
     * @param order order.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setOrder(final int order) {
      this.order = order;
      return this;
    }

    /**
     * <p>Change Company Name Value.</p>
     *
     * @param companyName company name.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setCompanyName(final String companyName) {
      this.companyName = companyName;
      return this;
    }

    /**
     * <p>Change company link Value.</p>
     *
     * @param companyLink Company website or professional address link.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setCompanyLink(final String companyLink) {
      this.companyLink = companyLink;
      return this;
    }

    /**
     * <p>Change Image Url Value.</p>
     *
     * @param companyImageUrl company logo url.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setCompanyImageUrl(final String companyImageUrl) {
      this.companyImageUrl = companyImageUrl;
      return this;
    }

    /**
     * <p>Change Location Value.</p>
     *
     * @param location location.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setLocation(final String location) {
      this.location = location;
      return this;
    }

    /**
     * <p>Change startDate Value.</p>
     *
     * @param startDate start date.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setStartDate(final String startDate) {
      this.startDate = startDate;
      return this;
    }

    /**
     * <p>Change end date Value.</p>
     *
     * @param endDate endDate.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setEndDate(final String endDate) {
      this.endDate = endDate;
      return this;
    }

    /**
     * <p>Change isCurrentlyWorking Value.</p>
     *
     * @param isCurrentlyWorking to Know if user works there yet.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setIsCurrentlyWorking(
            final boolean isCurrentlyWorking
    ) {
      this.isCurrentlyWorking = isCurrentlyWorking;
      return this;
    }

    /**
     * <p>Change skills Value.</p>
     *
     * @param skills skills related with this experience.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setSkills(final Skill[] skills) {
      this.skills = skills;
      return this;
    }

    /**
     * <p>Change tasks Value.</p>
     *
     * @param tasks to describe actions in this experience.
     * @return ExperienceBuilder
     */
    public ExperienceBuilder setTasks(final Task[] tasks) {
      this.tasks = tasks;
      return this;
    }

    /**
     * <p>Build new instance of Experience..</p>
     *
     * @return Experience.
     **/
    @Override
    public Experience buildEntity() {
      return new Experience(this);
    }
  }
}
