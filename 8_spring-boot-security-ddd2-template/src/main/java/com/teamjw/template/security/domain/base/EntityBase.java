package com.teamjw.template.security.domain.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Entity Base Class (Domain Driven Design 설명 참고)
 * 모든 Entity 들은 id 어트리뷰트를 가진다.
 * 
 *
 */
@MappedSuperclass
// 공통 맵핑 정보를 사용할 때 MappedSuperclass 사용
public abstract class EntityBase<T extends EntityBase<T>> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Returns the identity of this entity object.
	 * 
	 * @return the identity of this entity object
	 * 
	 * @deprecated You should not pass this identity to the interface layer, if you
	 *             can identify an entity by a domain key. You may use it in the
	 *             domain layer, as accesses by identity are more efficient.
	 *             2018-10-05 Knabe
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Entities compare by identity, not by attributes.
	 *
	 * @param that
	 *            The other entity of the same type
	 * @return true if the identities are the same, regardless of the other
	 *         attributes.
	 * @throws IllegalStateException
	 *             one of the entities does not have the identity attribute set.
	 */
	public boolean sameIdentityAs(final T that) {
		return this.equals(that);
	}

	@Override
	public boolean equals(final Object object) {
		if (!(object instanceof EntityBase)) {
			return false;
		}
		final EntityBase<?> that = (EntityBase<?>) object;
		_checkIdentity(this);
		_checkIdentity(that);
		return this.id.equals(that.getId());
	}

	/**
	 * Checks the passed entity, if it has an identity. It gets an identity only by
	 * saving.
	 * 
	 * @param entity
	 *            the entity to be checked
	 * @throws IllegalStateException
	 *             the passed entity does not have the identity attribute set.
	 */
	private void _checkIdentity(final EntityBase<?> entity) {
		if (entity.getId() == null) {
			throw new IllegalStateException("Identity missing in entity: " + entity);
		}
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

}
